package com.ecare.newu.e_care.public_portal;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ecare.newu.e_care.R;
import com.ecare.newu.e_care.ip_url;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class submit_image extends Fragment {
    ImageButton imageButton;
    ImageView imageView;
    Button button;
    int request_code = 1;
    Bitmap bitmap,bitmap1;
    TextView t1,t2;
    String user = "shubham";
    String filename = "";
    String image = "";

    public submit_image() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_submit_image, container, false);

        imageButton= (ImageButton) v.findViewById(R.id.tv);
        button = (Button) v.findViewById(R.id.button1);
        reqAskPermission(Manifest.permission.RECEIVE_SMS, 1001);
        reqAskPermission(Manifest.permission.SEND_SMS, 1002);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, request_code);
            }

        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server();
            }
        });
        t1 = (TextView) v.findViewById(R.id.textView25);
        t2 = (TextView) v.findViewById(R.id.textView26);

        t1.setText(getdate());
        t2.setText(gettime());
        return v;
    }


    public String getdate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }

    public String gettime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }

    public String gettime2()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == request_code) ;
        {

            try {
                Uri filePath = null;
                if(data!=null) {
                    filePath = data.getData();

                    bitmap1 = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
                    Bundle b = data.getExtras();
                    Bitmap bmp = (Bitmap) b.get("data");
                    imageButton.setImageBitmap(bmp);
                    // image = bmp.toString();
                    t1.setText(getdate());
                    t2.setText(gettime());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void reqAskPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(getContext(), permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{permission}, requestCode);
        } else

        {
            Toast.makeText(getContext(), "Permission_Granted", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1001:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {

                }
                break;
            case 1002:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {

                }
                break;
            default:

        }
        return;
    }


    public void server() {
        filename = user + "-"+ gettime2();
        ip_url u   = new ip_url();

       // Toast.makeText(getContext(), "enter", Toast.LENGTH_SHORT).show();

        String ip = u.geturl();
        String json_url_name = ip+"add.php";
        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, json_url_name, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                //    Toast.makeText(getContext(), ""+response, Toast.LENGTH_SHORT).show();
                    if(response.equals("1"))
                    upload_image();
                    else
                        Toast.makeText(getContext(), "Error.. try again", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Server Error"+error, Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", user);
                params.put("date", t1.getText().toString());
                params.put("time", t2.getText().toString());
                params.put("image", filename);
                return params;
            }
        };
        RequestQueue re = Volley.newRequestQueue(getContext());
        re.add(stringRequest1);
    }


    public void upload_image() {
        filename = user + "-"+ gettime2();
        ip_url u   = new ip_url();

        String ip = u.geturl();
        String json_url_name = ip+"upload_image.php";
        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, json_url_name, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                  if(response.equals("1"))
                  {
                      Toast.makeText(getContext(), "Thank You for your contribution", Toast.LENGTH_SHORT).show();
                  }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Server Error", Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String image = getStringImage(bitmap1);
                Map<String, String> params = new HashMap<String, String>();
                params.put("filename", filename);
                params.put("image", image);
                return params;
            }
        };

        RequestQueue re = Volley.newRequestQueue(getActivity());
        re.add(stringRequest1);
    }


    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 20, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        image = encodedImage;
        return encodedImage;
    }
}