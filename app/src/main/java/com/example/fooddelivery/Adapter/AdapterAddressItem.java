package com.example.fooddelivery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.R;

import java.util.List;

public class AdapterAddressItem  extends RecyclerView.Adapter<AdapterAddressItem.AddressViewHolder> {


    public interface IClickItem {
        void setPosition(int position);
    }

    private Context context;
    private int layout;
    private List<String> arrList;

    private IClickItem iClickItem ;

    public AdapterAddressItem(Context context,
                              int layout,
                              List<String> arrList,
                              IClickItem item
                              ) {
        this.context = context;
        this.layout = layout;
        this.arrList = arrList;
        this.iClickItem = item;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address,parent,false);

        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        String dataContent = arrList.get(position);
        holder.txtName.setText(dataContent);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItem.setPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrList.size();
    }

    public class AddressViewHolder extends RecyclerView.ViewHolder{
        TextView txtName ;
        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.tv_address);
        }
    }
}

