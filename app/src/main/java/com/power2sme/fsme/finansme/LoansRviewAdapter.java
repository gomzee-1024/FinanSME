package com.power2sme.fsme.finansme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sysadmin on 17/11/16.
 */

public class LoansRviewAdapter extends RecyclerView.Adapter<LoansRviewAdapter.LoansViewHolder> {
    Context context;
    LayoutInflater layoutInflater;

    public LoansRviewAdapter(Context context){
        this.context = context;
        layoutInflater = layoutInflater.from(context);
    }

    @Override
    public LoansViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.loans_card,parent,false);
        LoansViewHolder viewHolder = new LoansViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LoansViewHolder holder, int position) {
        switch (position){
            case 0: holder.status.setText("In Request");
                    holder.status.setBackgroundResource(R.color.loans_require_submission);
                break;
            case 1: holder.status.setText("Approved");
                    holder.status.setBackgroundResource(R.color.loans_accepted);
                break;
            case 2: holder.status.setText("In Process");
                    holder.status.setBackgroundResource(R.color.loans_in_process);
                break;
            case 3: holder.status.setText("Rejected");
                    holder.status.setBackgroundResource(R.color.loans_rejected);
                    break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class LoansViewHolder extends RecyclerView.ViewHolder{

        TextView status;

        public LoansViewHolder(View itemView) {
            super(itemView);
            status = (TextView) itemView.findViewById(R.id.loan_status);
        }
    }
}
