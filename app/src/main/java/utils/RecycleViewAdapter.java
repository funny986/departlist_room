package utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.departlistv3.R;
import dataBases.Contacts;

import java.util.List;

import static utils.ListWork.inputNumberPhoneMask;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context mContext;
    public List<Contacts> mData;
    Dialog myDialog;

    public void setmData(List<Contacts> Data) {
        this.mData = Data;
        notifyDataSetChanged();
    }

    public RecycleViewAdapter(Context context, List<Contacts> mData) {
        this.mContext = context;
        this.mData = mData;

    }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            view = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent, false);
            final MyViewHolder myViewHolder = new MyViewHolder(view);
            myDialog = new Dialog(parent.getContext());
            myDialog.setContentView(R.layout.dialog_contact);
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myViewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TextView dialog_lastname_tv = myDialog.findViewById(R.id.dialod_lastname_id);
                    TextView dialog_firstname_tv = myDialog.findViewById(R.id.dialod_firstname_id);
                    TextView dialog_position_tv = myDialog.findViewById(R.id.dialod_positionname_id);
                    final TextView dialog_phone_tv = myDialog.findViewById(R.id.dialog_phone_id);
                    inputNumberPhoneMask(dialog_phone_tv);
                    dialog_lastname_tv.setText(mData.get(myViewHolder.getAdapterPosition()).getLastName());
                    dialog_firstname_tv.setText(mData.get(myViewHolder.getAdapterPosition()).getFirstName()
                     + "  " +  mData.get(myViewHolder.getAdapterPosition()).getMiddleName());
                    dialog_position_tv.setText(mData.get(myViewHolder.getAdapterPosition()).getPositionName());
                    dialog_phone_tv.setText(mData.get(myViewHolder.getAdapterPosition()).getPhone());
                    Toast.makeText(mContext, "" + mData.get(myViewHolder.getAdapterPosition()).getLastName(),
                            Toast.LENGTH_SHORT)
                            .show();
                    myDialog.show();

                    Button phone = myDialog.findViewById(R.id.dialog_button_name);
                    phone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            intent.setData(Uri.parse("tel:" + dialog_phone_tv.getText()));
                            mContext.startActivity(intent);
                        }
                    });
                    Button msg = myDialog.findViewById(R.id.dialog_button_message);
                    msg.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent sms = new Intent(Intent.ACTION_SENDTO);
                            sms.setData(Uri.parse("smsto:" + dialog_phone_tv.getText()));
                            mContext.startActivity(sms);
                        }
                    });
                }
            });
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
            holder.tv_last_name.setText(mData.get(position).getLastName() + "   " +
                    mData.get(position).getFirstName().charAt(0) + "." + " " +
                    mData.get(position).getMiddleName().charAt(0) + ".");
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        private final TextView tv_last_name;
        private final LinearLayout item_contact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_last_name = itemView.findViewById(R.id.last_name_contact);
//            ImageView img = itemView.findViewById(R.id.img_contact);
            item_contact = itemView.findViewById(R.id.contact_item_id);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(@NonNull ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(), R.id.edit_context , 0, "Править данные");
            menu.add(this.getAdapterPosition(), R.id.delete_context, 0, "Удалить контакт");
        }
    }
}
