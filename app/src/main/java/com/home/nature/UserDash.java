package com.home.nature;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.home.nature.R.id;
import com.home.nature.databinding.ActivityUserDashBinding;

import kotlin.jvm.internal.Intrinsics;
public class UserDash extends Activity {
    private ActivityUserDashBinding binding;
    private Button saveButton;
    private EditText TreatYourself;
    private EditText Essentials;
    private EditText Finance;
    private EditText setDate;
    private Button BTNEDT;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View var10001 = this.findViewById(id.filled_edit_text1);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.filled_edit_text1)");
        this.TreatYourself = (EditText)var10001;
        var10001 = this.findViewById(id.filled_edit_text2);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.filled_edit_text2)");
        this.Essentials = (EditText)var10001;
        var10001 = this.findViewById(id.filled_edit_text2);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.filled_edit_text2)");
        this.Finance = (EditText)var10001;
        var10001 = this.findViewById(id.date_totalsavings);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.date_totalsavings)");
        this.setDate = (EditText)var10001;
        var10001 = this.findViewById(id.todashedit);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.todashedit)");
        this.BTNEDT = (Button)var10001;
        ActivityUserDashBinding var2 = ActivityUserDashBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(var2, "ActivityUserDashBinding.inflate(layoutInflater)");
        this.binding = var2;
        var2 = this.binding;
        if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }

        this.setContentView((View)var2.getRoot());
        Button var10000 = this.BTNEDT;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("BTNEDT");
        }

        var10000.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)UserDash.this, UserDash.class);
                String message = UserDash.access$getTreatYourself$p(UserDash.this).getText().toString();
                intent.putExtra("message_key", message);
                UserDash.this.startActivity(intent);
            }
        }));
    }

    // $FF: synthetic method
    public static final EditText access$getTreatYourself$p(UserDash $this) {
        EditText var10000 = $this.TreatYourself;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("TreatYourself");
        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setTreatYourself$p(UserDash $this, EditText var1) {
        $this.TreatYourself = var1;
    }
}

