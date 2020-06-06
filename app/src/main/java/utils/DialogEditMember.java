package utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.departlistv3.R;
import dataBases.Contacts;

import static com.departlistv3.MainActivity.lstContact;


public class DialogEditMember extends DialogFragment {

    private String choiseEdit = "";
    private NoticeDialogListener mListener;

    public interface NoticeDialogListener {
         void onDialogPositiveClick(DialogFragment dialog, Contacts contact);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.CustomAlert));
        final String[] choiseForEdit = new String[lstContact.size()];
        final int[] took_id = new int[1];
        for (int r =0; r < lstContact.size(); r++ ) {
            choiseForEdit[r] = lstContact.get(r).getLastName();
        }
        builder.setTitle("Править! Выберите контакт:")
                .setIcon(R.drawable.ic_edit_member)
                .setCancelable(true)
                .setSingleChoiceItems(choiseForEdit, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {
                                took_id[0] = item;
                                choiseEdit = choiseForEdit[item];
                            }
                        })
                .setPositiveButton("Изменение", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),
                                getString(R.string.toast_editDialog) + choiseEdit,
                                Toast.LENGTH_SHORT)
                                .show();
                        mListener.onDialogPositiveClick(DialogEditMember.this, lstContact.get(took_id[0]));
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogNegativeClick(DialogEditMember.this);
                    }
                });
        return builder.create();
    }
}
