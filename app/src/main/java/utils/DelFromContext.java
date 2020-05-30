package utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.departlistv3.R;
import dataBases.Contacts;

import static com.departlistv3.MainActivity.departDataBase;

public class DelFromContext extends DialogFragment {
    private int id_del;
    private String message;

    public void setId_del(int id_del, String message) {
        this.id_del = id_del;
        this.message = "Удалить контакт: " + message +
                "\nокончательно?";
    }

    private DelFromContext.NoticeDialogListener mListener;

    public interface NoticeDialogListener {
        void onDialogPositiveClick(DialogFragment dialog);
        void onDialogNegativeClick(DialogFragment dialog);
    }
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (DelFromContext.NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Удаление")
                .setIcon(R.drawable.ic_action_cross)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton("Удалить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Contacts contactsDelete = departDataBase.contactsDao().getContactsList(id_del);
                        departDataBase.contactsDao().delete(contactsDelete);
                        Activity activity = getActivity();
                        Toast.makeText(activity,
                                R.string.toast_delCont,
                                Toast.LENGTH_SHORT)
                                .show();
                        mListener.onDialogPositiveClick(DelFromContext.this);
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogNegativeClick(DelFromContext.this);
                    }
                });
        return builder.create();
    }

}
