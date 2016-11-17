package com.power2sme.fsme.finansme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sysadmin on 16/11/16.
 */

public class LoansCountRviewAdapter extends RecyclerView.Adapter<LoansCountRviewAdapter.LoansCountViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    public LoansCountRviewAdapter(Context context){
        this.context = context;
        layoutInflater  = layoutInflater.from(context);
    }

    @Override
    public LoansCountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.loans_rview_card,parent,false);
        LoansCountViewHolder viewHolder = new LoansCountViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LoansCountViewHolder holder, int position) {
        switch (position){
            case 0 : holder.primaryTextView.setText("Loans Approved");
                     holder.secondaryTextView.setText("Loans requests which have been approved till now");
                     holder.loansCount.setText("2");
                     holder.loansCount.setTextColor(context.getResources().getColor(R.color.loans_approved_text));
                     holder.loanIcon.setImageResource(R.drawable.loans_approved);
                break;
            case 1 : holder.primaryTextView.setText("Loans In Process");
                holder.secondaryTextView.setText("Loans requests which are being reviewed by our team");
                holder.loansCount.setText("2");
                holder.loansCount.setTextColor(context.getResources().getColor(R.color.loans_in_process_text));
                holder.loanIcon.setImageResource(R.drawable.loans_in_process);
                break;
            case 2 : holder.primaryTextView.setText("Loans Rejected");
                holder.secondaryTextView.setText("Loans requests which have been rejected till now");
                holder.loansCount.setText("2");
                holder.loansCount.setTextColor(context.getResources().getColor(R.color.loans_rejected_text));
                holder.loanIcon.setImageResource(R.drawable.loans_rejected);
                break;
            case 3 : holder.primaryTextView.setText("Loans Yet To Process");
                holder.secondaryTextView.setText("Loans request which are remaining to process by us");
                holder.loansCount.setText("2");
                holder.loansCount.setTextColor(context.getResources().getColor(R.color.loans_yet_to_be_processed_text));
                holder.loanIcon.setImageResource(R.drawable.loan_request_yet_to_process);
                break;
            case 4 : holder.primaryTextView.setText("Loans Requiring Input");
                holder.secondaryTextView.setText("Loans request which require input from you");
                holder.loansCount.setText("2");
                holder.loansCount.setTextColor(context.getResources().getColor(R.color.loans_require_input_text));
                holder.loanIcon.setImageResource(R.drawable.loans_requiring_input);
                break;
            case 5 : holder.primaryTextView.setText("Loans Yet to Submit");
                holder.secondaryTextView.setText("Loans request which are not submited by you till now");
                holder.loansCount.setText("2");
                holder.loansCount.setTextColor(context.getResources().getColor(R.color.loans_require_submission_text));
                holder.loanIcon.setImageResource(R.drawable.loan_request_require_submision);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class LoansCountViewHolder extends RecyclerView.ViewHolder{

        TextView primaryTextView,secondaryTextView,loansCount;
        ImageView loanIcon;
        public LoansCountViewHolder(View itemView) {
            super(itemView);
            primaryTextView = (TextView) itemView.findViewById(R.id.primary_text);
            secondaryTextView = (TextView) itemView.findViewById(R.id.secondary_text);
            loansCount = (TextView) itemView.findViewById(R.id.loans_count);
            loanIcon = (ImageView) itemView.findViewById(R.id.loan_icon);
        }
    }
}
