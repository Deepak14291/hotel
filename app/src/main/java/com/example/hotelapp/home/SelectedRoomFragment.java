package com.example.hotelapp.home;



import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hotelapp.R;
import com.example.hotelapp.model.RoomType;


public class SelectedRoomFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selected_room, container, false);

        // Get references to the ImageView and TextView elements
        ImageView selectedRoomImage = view.findViewById(R.id.selected_room_image);
        TextView selectedRoomName = view.findViewById(R.id.selected_room_name);
        TextView selectedRoomPrice = view.findViewById(R.id.selected_room_price);
      RoomType selectedRoom=((HomeActivity) getActivity()).getRoomType();
        // Set static data
        selectedRoomImage.setImageResource(selectedRoom.getImg()); // Replace with your room's image resource
        selectedRoomName.setText(selectedRoom.getName()); // Replace with the room name
        selectedRoomPrice.setText(selectedRoom.getPrice()); // Replace with the room price
        Button buttonSelectDates=view.findViewById(R.id.book_button);


        buttonSelectDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();

            }
        });


        return view;
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
                        // Handle the selected date
                        String selectedDate =  " "+day+ "-" +(month + 1)+"-"+year+"" ; // Month is 0-based
                        // You can use the selected date as needed
                        Toast.makeText(getContext(),getString(R.string.selected_date)+selectedDate,Toast.LENGTH_SHORT).show();
                    }
                },
                // Set the initial date in the dialog (optional)
                2023, 0, 1 // Year, month, day (month is 0-based)
        );

        datePickerDialog.show();
    }
}
