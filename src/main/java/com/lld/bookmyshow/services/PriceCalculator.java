package com.lld.bookmyshow.services;
import com.lld.bookmyshow.models.Show;
import com.lld.bookmyshow.models.ShowSeat;
import com.lld.bookmyshow.models.ShowSeatType;
import com.lld.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculator {
    private final ShowSeatTypeRepository showSeatTypeRepository;
    PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public int calculatePrice(List<ShowSeat> showSeats, Show show) {
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        int amount = 0;
        // 1. Find out the type of seats in the given show
        for (ShowSeat showSeat : showSeats) {
            // 2. Get seatTypes for all the selected seats
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    // 3. Calculate the amount
                   amount += showSeatType.getPrice();
                }
            }
        }
        return amount;
    }
}
