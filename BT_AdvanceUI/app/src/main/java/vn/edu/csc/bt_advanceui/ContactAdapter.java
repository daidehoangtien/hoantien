package vn.edu.csc.bt_advanceui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class  ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactVH> {

    ArrayList<Contact> contacts;
    Context context;
    OnClick listener;



    public ContactAdapter( Context context, ArrayList<Contact> contacts) {
        this.contacts = contacts;
        this.context = context;
    }

    public ContactAdapter(ArrayList<Contact> contacts, Context context, OnClick listener) {
        this.contacts = contacts;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_contact, parent, false);
        ContactVH contactVH = new ContactVH(view);
        return contactVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactVH holder, int position) {
        Contact contact = contacts.get(position);
        holder.tvAvatar.setText(contact.getAvatar());
        holder.tvName.setText(contact.getName());
// Cach 1
//        holder.ivPhone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, contact.getPhone(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, contact.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.setOnClick(contact);
//            }
//        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.setOnLongClick(contact, position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactVH extends RecyclerView.ViewHolder{

        TextView tvAvatar, tvName;
        ImageView ivPhone, ivMessage;

        public ContactVH(@NonNull View itemView) {
            super(itemView);
            tvAvatar = itemView.findViewById(R.id.tvAvatar);
            tvName = itemView.findViewById(R.id.tvName);
            ivPhone = itemView.findViewById(R.id.ivPhone);
            ivMessage = itemView.findViewById(R.id.ivMessage);
        }
    }

    public interface OnClick{
        void setOnLongClick(Contact contact, int pos);

    }
}
