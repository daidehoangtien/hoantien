package vn.edu.csc.bt_advanceui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity implements ContactAdapter.OnClick {
    ArrayList<Contact> contacts;
    ContactAdapter contactAdapter;
    RecyclerView rvContacts;

    Toolbar toolbar;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        rvContacts = findViewById(R.id.rvContacts);
        contacts = initData();
//        contactAdapter = new ContactAdapter( ContactActivity.this, contacts);
        contactAdapter = new ContactAdapter(contacts,
                ContactActivity.this,ContactActivity.this);
        rvContacts.setAdapter(contactAdapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(ContactActivity.this,
                LinearLayoutManager.VERTICAL, false));
        rvContacts.addItemDecoration(new DividerItemDecoration(
                ContactActivity.this, LinearLayoutManager.VERTICAL));

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        registerForContextMenu(rvContacts);
    }

    private ArrayList<Contact> initData() {
        ArrayList<Contact> tmp = new ArrayList<>();
        tmp.add(new Contact("Gary Hawkins", "0909090909"));
        tmp.add(new Contact("Mike Lasson", "0909090909"));
        tmp.add(new Contact("Jose Alexander", "0909090909"));
        tmp.add(new Contact("Stephanie Gardner", "0909090909"));
        tmp.add(new Contact("Nancy Greene ", "0909090909"));
        tmp.add(new Contact("Gary Hawkins", "0909090909"));
        tmp.add(new Contact("Mike Lasson", "0909090909"));
        tmp.add(new Contact("Jose Alexander", "0909090909"));
        tmp.add(new Contact("Stephanie Gardner", "0909090909"));
        tmp.add(new Contact("Nancy Greene ", "0909090909"));
        return tmp;
    }


    @Override
    public void setOnLongClick(Contact contact, int pos) {
        Toast.makeText(this, contact.toString(), Toast.LENGTH_SHORT).show();
        position = pos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnu_add:
                Contact contact = new Contact("Tom Vu", "0972277977");
                contacts.add(contact);
                contactAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Menu Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnu_info:
                Toast.makeText(this, "Menu Info", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnu_edit:
                Contact contact = new Contact("ABC ABC", "CDE");
                contacts.set(position, contact);
                contactAdapter.notifyDataSetChanged();
                break;
            case R.id.mnu_delete:
                contacts.remove(position);
                contactAdapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }
}