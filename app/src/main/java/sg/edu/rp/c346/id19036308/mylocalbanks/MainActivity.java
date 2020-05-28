package sg.edu.rp.c346.id19036308.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        if(v.equals(tvDBS)== true){
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");
        } else if (v.equals(tvOCBC)== true){
            menu.add(1,2,0,"Website");
            menu.add(1,3,1,"Contact the bank");
        } else if(v.equals(tvUOB)==true){
            menu.add(2,4,0,"Website");
            menu.add(2,5,1,"Contact the bank");
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
            startActivity(intent);

            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbsPhoneNum)));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==2) { //check if the selected menu item ID is 1
            //code for action
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
            startActivity(intent);
            return true;
        }
        else if(item.getItemId()==3) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.ocbcPhoneNum)));
            startActivity(intentCall);
            return true;
        }
        else if(item.getItemId()==4) { //check if the selected menu item ID is 1
            //code for action
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
            startActivity(intent);
            return true;
        }
        else if(item.getItemId()==5) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uobPhoneNum)));
            startActivity(intentCall);
            return true;
        }



        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.englishSelection) {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText(getString(R.string.dbsChiName));
            tvOCBC.setText(getString(R.string.ocbcChiName));
            tvUOB.setText(getString(R.string.uobChiName));
            return true;
        } else {
            tvDBS.setText(getString(R.string.error));
            tvOCBC.setText(getString(R.string.error));
            tvUOB.setText(getString(R.string.error));
        }


        return super.onOptionsItemSelected(item);
    }



}
