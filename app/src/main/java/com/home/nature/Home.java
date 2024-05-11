package com.home.nature;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.home.nature.R.id;
import com.home.nature.R.layout;
import com.home.nature.admin.dashboard;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 9, 0},
        k = 1,
        d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00109\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0013H\u0002J\u0012\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001c\u0010$\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001c\u00100\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001a\u00103\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001a\u00106\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011¨\u0006>"},
        d2 = {"Lcom/home/nature/Home;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "BTNTodash", "Landroid/widget/Button;", "getBTNTodash", "()Landroid/widget/Button;", "setBTNTodash", "(Landroid/widget/Button;)V", "BTN_001", "getBTN_001", "setBTN_001", "account_section", "Landroid/widget/ImageView;", "getAccount_section", "()Landroid/widget/ImageView;", "setAccount_section", "(Landroid/widget/ImageView;)V", "alphisTextView", "Landroid/widget/TextView;", "getAlphisTextView", "()Landroid/widget/TextView;", "setAlphisTextView", "(Landroid/widget/TextView;)V", "alphisTextViewDialog", "Landroidx/appcompat/app/AlertDialog;", "getAlphisTextViewDialog", "()Landroidx/appcompat/app/AlertDialog;", "setAlphisTextViewDialog", "(Landroidx/appcompat/app/AlertDialog;)V", "card_section", "getCard_section", "setCard_section", "coin_section", "getCoin_section", "setCoin_section", "dialog", "getDialog", "setDialog", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "setEditText", "(Landroid/widget/EditText;)V", "home_section", "getHome_section", "setHome_section", "textView", "getTextView", "setTextView", "textViewDialog", "getTextViewDialog", "setTextViewDialog", "user_section", "getUser_section", "setUser_section", "createDialog", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
public final class Home extends AppCompatActivity {
    public ImageView card_section;
    public ImageView home_section;
    public ImageView account_section;
    public ImageView coin_section;
    public Button BTNTodash; 
    public ImageView user_section;
    public Button BTN_001;
    @Nullable
    private TextView textView;
    @Nullable
    private AlertDialog dialog;
    @Nullable
    private EditText editText;
    public AlertDialog textViewDialog;
    public AlertDialog alphisTextViewDialog;
    @Nullable
    private TextView alphisTextView;

    @NotNull
    public final ImageView getCard_section() {
        ImageView var10000 = this.card_section;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card_section");
        }

        return var10000;
    }

    public final void setCard_section(@NotNull ImageView var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.card_section = var1;
    }

    @NotNull
    public final ImageView getHome_section() {
        ImageView var10000 = this.home_section;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("home_section");
        }

        return var10000;
    }

    public final void setHome_section(@NotNull ImageView var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.home_section = var1;
    }

    @NotNull
    public final ImageView getAccount_section() {
        ImageView var10000 = this.account_section;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("account_section");
        }

        return var10000;
    }

    public final void setAccount_section(@NotNull ImageView var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.account_section = var1;
    }

    @NotNull
    public final ImageView getCoin_section() {
        ImageView var10000 = this.coin_section;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coin_section");
        }

        return var10000;
    }

    public final void setCoin_section(@NotNull ImageView var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.coin_section = var1;
    }

    @NotNull
    public final Button getBTNTodash() {
        Button var10000 = this.BTNTodash;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("BTNTodash");
        }

        return var10000;
    }

    public final void setBTNTodash(@NotNull Button var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.BTNTodash = var1;
    }

    @NotNull
    public final ImageView getUser_section() {
        ImageView var10000 = this.user_section;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("user_section");
        }

        return var10000;
    }

    public final void setUser_section(@NotNull ImageView var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.user_section = var1;
    }

    @NotNull
    public final Button getBTN_001() {
        Button var10000 = this.BTN_001;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("BTN_001");
        }

        return var10000;
    }

    public final void setBTN_001(@NotNull Button var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.BTN_001 = var1;
    }

    @Nullable
    public final TextView getTextView() {
        return this.textView;
    }

    public final void setTextView(@Nullable TextView var1) {
        this.textView = var1;
    }

    @Nullable
    public final AlertDialog getDialog() {
        return this.dialog;
    }

    public final void setDialog(@Nullable AlertDialog var1) {
        this.dialog = var1;
    }

    @Nullable
    public final EditText getEditText() {
        return this.editText;
    }

    public final void setEditText(@Nullable EditText var1) {
        this.editText = var1;
    }

    @NotNull
    public final AlertDialog getTextViewDialog() {
        AlertDialog var10000 = this.textViewDialog;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textViewDialog");
        }

        return var10000;
    }

    public final void setTextViewDialog(@NotNull AlertDialog var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.textViewDialog = var1;
    }

    @NotNull
    public final AlertDialog getAlphisTextViewDialog() {
        AlertDialog var10000 = this.alphisTextViewDialog;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alphisTextViewDialog");
        }

        return var10000;
    }

    public final void setAlphisTextViewDialog(@NotNull AlertDialog var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.alphisTextViewDialog = var1;
    }

    @Nullable
    public final TextView getAlphisTextView() {
        return this.alphisTextView;
    }

    public final void setAlphisTextView(@Nullable TextView var1) {
        this.alphisTextView = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_home2);
        View var10001 = this.findViewById(id.accountsection);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.accountsection)");
        this.account_section = (ImageView)var10001;
        var10001 = this.findViewById(id.coinsection);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.coinsection)");
        this.coin_section = (ImageView)var10001;
        var10001 = this.findViewById(id.usersection);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.usersection)");
        this.user_section = (ImageView)var10001;
        var10001 = this.findViewById(id.todashedit);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.todashedit)");
        this.BTNTodash = (Button)var10001;
        var10001 = this.findViewById(id.textView001);
        Intrinsics.checkNotNull(var10001);
        if (var10001 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        } else {
            this.textView = (TextView)var10001;
            var10001 = this.findViewById(id.AlfisTextView);
            if (var10001 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            } else {
                this.alphisTextView = (TextView)var10001;
                this.dialog = (new AlertDialog.Builder((Context)this)).create();
                this.editText = new EditText((Context)this);
                TextView var10002 = this.textView;
                Intrinsics.checkNotNull(var10002);
                this.textViewDialog = this.createDialog(var10002);
                var10002 = this.alphisTextView;
                Intrinsics.checkNotNull(var10002);
                this.alphisTextViewDialog = this.createDialog(var10002);
                Button var10000 = this.BTNTodash;
                if (var10000 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("BTNTodash");
                }

                var10000.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        Intent todash = new Intent((Context)Home.this, UserDash.class);
                        Home.this.startActivity(todash);
                    }
                }));
                ImageView var2 = this.account_section;
                if (var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("account_section");
                }

                var2.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                    public final void onClick(View it) {
                        Intent toaccounts = new Intent((Context)Home.this, MainActivity.class);
                        Home.this.startActivity(toaccounts);
                    }
                }));
            }
        }
    }

    private final AlertDialog createDialog(final TextView textView) {
        AlertDialog var10000 = (new AlertDialog.Builder((Context)this)).create();
        Intrinsics.checkNotNullExpressionValue(var10000, "AlertDialog.Builder(this).create()");
        final AlertDialog dialog = var10000;
        final EditText editText = new EditText((Context)this);
        dialog.setTitle((CharSequence)"Edit the text");
        dialog.setView((View)editText);
        dialog.setButton(-1, (CharSequence)"SAVE TEXT", (DialogInterface.OnClickListener)(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface $noName_0, int $noName_1) {
                textView.setText((CharSequence)editText.getText().toString());
            }
        }));
        textView.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                editText.setText(textView.getText());
                dialog.show();
            }
        }));
        return dialog;
    }
}
