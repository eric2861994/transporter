package com.kargo.transporter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

/**
 * Displays the sorting dialog.
 * The dialog consists of four buttons for each sorting option.
 *
 * Activity displaying this dialog should implement SortDialogInterface
 */
public class SortDialog extends DialogFragment {

    public interface SortDialogListener {
        void sortData(SortEnum sortBy, boolean ascending);
    }

    private SortDialogListener listener;

    public void setListener(SortDialogListener alistener) {
        listener = alistener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sort_dialog, container, false);

        // Watch for button clicks.
        Button price_asc = v.findViewById(R.id.price_asc);
        Button price_desc = v.findViewById(R.id.price_desc);

        price_asc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.sortData(SortEnum.PRICE, true);
                dismiss();
            }
        });

        price_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.sortData(SortEnum.PRICE, false);
                dismiss();
            }
        });

        return v;
    }
}
