package com.dedykuncoro.multiplechoice;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.dedykuncoro.multiplechoice.adapter.Adapter;
import com.dedykuncoro.multiplechoice.app.AppController;
import com.dedykuncoro.multiplechoice.data.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kuncoro on 20/03/2016.
 */
public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    FloatingActionButton fab;
    ListView list;
    TextView txt_menu;
    String dipilih;
    private static final String TAG = MainActivity.class.getSimpleName();

    Adapter adapter;
    ProgressDialog pDialog;

    List<Data> itemList = new ArrayList<Data>();

    // Sesuaikan dengan IP Address PC/LAptop atau ip emulator bawaan android 10.0.2.2
    private static String url = "http://172.20.10.2/android/kuncoro_multiple_choice/menu.php";

    public static final String TAG_NAMA = "nama";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab     = (FloatingActionButton) findViewById(R.id.fab);
        list    = (ListView) findViewById(R.id.list_menu);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checkbox = "";
                for (Data hold : adapter.getAllData()) {
                    if (hold.isCheckbox()) {
                        checkbox += "\n" + hold.getMenu();
                    }
                }
                if (!checkbox.isEmpty()) {
                    dipilih = checkbox;
                } else {
                    dipilih = "Anda Belum Memilih Menu.";
                }

                formSubmit(dipilih);
            }
        });

        callVolley();

        adapter = new Adapter(this, (ArrayList<Data>) itemList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                adapter.setCheckBox(position);
            }
        });

    }

    private void formSubmit(String hasil){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.form_submit, null);
        dialog.setView(dialogView);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Menu Yang Dipilih");
        dialog.setCancelable(true);

        txt_menu = (TextView) dialogView.findViewById(R.id.txt_menu);

        txt_menu.setText(hasil);

        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void callVolley(){
        itemList.clear();
        // menapilkan dialog loading
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        showDialog();

        // membuat request JSON
        JsonArrayRequest jArr = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hideDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);

                                Data item = new Data();

                                item.setMenu(obj.getString(TAG_NAMA));

                                // menambah item ke array
                                itemList.add(item);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        // notifikasi adanya perubahan data pada adapter
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hideDialog();
            }
        });

        // menambah request ke request queue
        AppController.getInstance().addToRequestQueue(jArr);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
