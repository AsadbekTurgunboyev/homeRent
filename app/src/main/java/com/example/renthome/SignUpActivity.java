package com.example.renthome;

import static com.example.renthome.Const.KEY;
import static com.example.renthome.Const.NAME;
import static com.example.renthome.Const.PASSWORD;
import static com.example.renthome.Const.ROLE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    MaterialButton btnKirish;
    Dialog dialog;
    private TextInputLayout txtName, txtPass;
    FirebaseDatabase database;
    DatabaseReference myRef;
    PreferenceData data;

//    List<LoginModel> loginModelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();
        setDialog();
        data = new PreferenceData(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");

        btnKirish.setOnClickListener(this);
    }

    private void initViews() {
        txtName = findViewById(R.id.textInputLayout);
        txtPass = findViewById(R.id.txtPas);
        btnKirish = findViewById(R.id.btnKirish);
    }

    @Override
    public void onClick(View view) {
        if (TextUtils.isEmpty(Objects.requireNonNull(txtName.getEditText()).getText().toString())) {
            txtName.setError("Foydalanuvchi nomini kiriting");
            return;
        }
        if (TextUtils.isEmpty(Objects.requireNonNull(txtPass.getEditText()).getText().toString())) {
            txtPass.setError("Parolni kiriting");
            return;
        }
        dialog.show();
        myRef.addListenerForSingleValueEvent(listener);


    }
    private void setDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

    ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            int i = 0;
            for (DataSnapshot ds : snapshot.getChildren()) {
                LoginModel model = ds.getValue(LoginModel.class);
                if (model != null) {
                    if (model.getName().equals(txtName.getEditText().getText().toString().trim()) && model.getPassword().equals(txtPass.getEditText().getText().toString().trim())) {
                        data.saveData(NAME, model.getName());
                        data.saveData(PASSWORD, model.getPassword());
                        data.saveData(KEY, ds.getKey());
                        data.saveData(ROLE, model.getRole());
                        dialog.dismiss();
                        Toast.makeText(SignUpActivity.this, "Ma'lumotlar tasdiqlandi!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        SignUpActivity.this.finish();
                        break;
                    }
                    i++;
                }

            }
            if (i >= snapshot.getChildrenCount()) {
                dialog.dismiss();
                Toast.makeText(SignUpActivity.this, "Ma'lumotar topilmadi!", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            dialog.dismiss();
            Toast.makeText(SignUpActivity.this, "Xatolik yuz berdi.", Toast.LENGTH_SHORT).show();
        }
    };

}