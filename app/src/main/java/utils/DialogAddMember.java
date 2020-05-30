package utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.DialogFragment;

import com.departlistv3.R;
import static utils.ListWork.getDialogTtl;
import static utils.ListWork.getTextToDialog;

public class DialogAddMember extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                builder.setView(inflater.inflate(R.layout.member_add, null))
                        .setIcon(R.drawable.ic_add_member)
                        .setMessage(getTextToDialog())
                        .setTitle(getDialogTtl())
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                return builder.create();
    }
}
