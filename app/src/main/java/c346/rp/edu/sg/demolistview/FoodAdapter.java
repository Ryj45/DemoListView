package c346.rp.edu.sg.demolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import c346.rp.edu.sg.demolistview.Food;
import c346.rp.edu.sg.demolistview.R;

public class FoodAdapter extends ArrayAdapter<Food> {
    private ArrayList<Food> food;
    private Context context;
    private TextView tvFoodName;
    private ImageView ivStar;

    public FoodAdapter(Context context, int resource, ArrayList<Food> objects){
        super(context, resource, objects);
        food = objects;
        this.context =context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvFoodName =(TextView) rowView.findViewById(R.id.tvFoodName);
        ivStar = (ImageView)rowView.findViewById(R.id.ivStar);

        Food currentFood = food.get(position);

        tvFoodName.setText(currentFood.getName());
        if (currentFood.isStar()){
            ivStar.setImageResource(R.drawable.star);
        }else{
            ivStar.setImageResource(R.drawable.nostar);
        }
        return rowView;
    }

}
