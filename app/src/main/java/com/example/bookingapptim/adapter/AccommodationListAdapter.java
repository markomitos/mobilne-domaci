package com.example.bookingapptim.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookingapptim.R;
import com.example.bookingapptim.models.Accommodation;

import java.util.ArrayList;

public class AccommodationListAdapter extends ArrayAdapter<Accommodation> {
    private ArrayList<Accommodation> accommodations;
    public AccommodationListAdapter(Context context, ArrayList<Accommodation> accommodations) {
        super(context, R.layout.accomodation_card, accommodations);
        this.accommodations = accommodations;
    }

    @Override
    public int getCount() {
        return accommodations.size();
    }

    /*
     * Ova metoda vraca pojedinacan element na osnovu pozicije
     * */
    @Nullable
    @Override
    public Accommodation getItem(int position) {
        return accommodations.get(position);
    }

    /*
     * Ova metoda vraca jedinstveni identifikator, za adaptere koji prikazuju
     * listu ili niz, pozicija je dovoljno dobra. Naravno mozemo iskoristiti i
     * jedinstveni identifikator objekta, ako on postoji.
     * */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
     * Ova metoda popunjava pojedinacan element ListView-a podacima.
     * Ako adapter cuva listu od n elemenata, adapter ce u petlji ici
     * onoliko puta koliko getCount() vrati. Prilikom svake iteracije
     * uzece java objekat sa odredjene poziciuje (model) koji cuva podatke,
     * i layout koji treba da prikaze te podatke (view) npr R.layout.product_card.
     * Kada adapter ima model i view, prosto ce uzeti podatke iz modela,
     * popuniti view podacima i poslati listview da prikaze, i nastavice
     * sledecu iteraciju.
     * */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Accommodation accommodation = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.accomodation_card,
                    parent, false);
        }
        LinearLayout productCard = convertView.findViewById(R.id.amenity_card_item);
        TextView amenityName = convertView.findViewById(R.id.amenity_name);
        TextView amenityDescription = convertView.findViewById(R.id.amenity_description);
        TextView amenityAddress = convertView.findViewById(R.id.amenity_address);
        TextView amenityPrice = convertView.findViewById(R.id.amenity_price);

        if(accommodation != null){
            amenityName.setText(accommodation.getName());
            amenityDescription.setText(accommodation.getDescription());
            amenityAddress.setText(accommodation.getAddress());
            amenityPrice.setText(accommodation.getPrice());
            productCard.setOnClickListener(v -> {
                // Handle click on the item at 'position'
                Log.i("ShopApp", "Clicked: " + accommodation.getName());
                Toast.makeText(getContext(), "Clicked: " + accommodation.getName()  , Toast.LENGTH_SHORT).show();
            });
        }

        return convertView;
    }
}
