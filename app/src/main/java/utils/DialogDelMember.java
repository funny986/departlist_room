package utils;

 import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.departlistv3.R;
 import dataBases.Contacts;

 import static com.departlistv3.MainActivity.departDataBase;
 import static com.departlistv3.MainActivity.lstContact;

public class DialogDelMember extends DialogFragment {

    private String choiseDeleting = "";
    private int id_del;
    private NoticeDialogListener mListener;

    public interface NoticeDialogListener {
         void onDialogPositiveClick(DialogFragment dialog);
         void onDialogNegativeClick(DialogFragment dialog);
    }
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String[] choiseForDel = new String[lstContact.size()];
        for (int r =0; r < lstContact.size(); r++ ) {
            choiseForDel[r] = lstContact.get(r).getLastName();
        }
        builder.setTitle("Удаление! Выберите контакт:")
                .setIcon(R.drawable.ic_action_cross)
                .setCancelable(true)
                .setSingleChoiceItems(choiseForDel, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {
                                id_del = lstContact.get(item).getId();
                                choiseDeleting = choiseForDel[item];
                            }
                        })
                .setPositiveButton("Удалить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Contacts contactsDelete = departDataBase.contactsDao().getContactsList(id_del);
                        departDataBase.contactsDao().delete(contactsDelete);
                        Toast.makeText(getActivity(),
                                choiseDeleting + getString(R.string.toast_delDialog),
                                Toast.LENGTH_SHORT)
                                .show();
                        mListener.onDialogPositiveClick(DialogDelMember.this);
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogNegativeClick(DialogDelMember.this);
                    }
                });
        return builder.create();
    }
}
