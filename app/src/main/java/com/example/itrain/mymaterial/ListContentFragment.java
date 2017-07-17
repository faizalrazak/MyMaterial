package com.example.itrain.mymaterial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */

public class ListContentFragment extends Fragment{

    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


       RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        //View rootView = inflater.inflate(R.layout.fragment_list_content, container, false);
        ContentAdapter adapter = new ContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        /*final Button button = (Button) recyclerView.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
        });*/

        // Set padding for Tiles (not needed for Cards/Lists!)
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return recyclerView;

    }

    public interface OnFragmentInteractionListener {
    }

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_content, container, false);
    }
*/
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_list_content, parent, false));
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;

        public ContentAdapter() {
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // no-op
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }

}
