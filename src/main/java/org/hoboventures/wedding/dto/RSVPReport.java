package org.hoboventures.wedding.dto;

import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;
import org.hoboventures.wedding.constants.RSVPCodeEnum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Asha on 9/12/2017.
 */
@Data
public class RSVPReport {

    private Long rsvpTotalCount;
    private Long rsvpAcceptCount;
    private Long rsvpWatchOnlineCount;
    private Long rsvpNeedTimeCount;
    private Long rsvpDeclineCount;

    private List<RSVPLite> rsvpList;

    public RSVPReport() {
        rsvpList = new ArrayList<>();
        resetCounts();
    }

    public RSVPReport(List<RSVP> rsvpList) {
        resetCounts();
        this.rsvpList = rsvpList.stream().map(rsvp -> new RSVPLite(rsvp)).collect(Collectors.toList());
        initCounts();
    }

    private void resetCounts() {
        rsvpNeedTimeCount = 0L;
        rsvpWatchOnlineCount = 0L;
        rsvpAcceptCount = 0L;
        rsvpDeclineCount = 0L;
        rsvpTotalCount = 0L;
    }

    public List<RSVPLite> getRsvpList() {
        if(rsvpList == null){
            rsvpList = new ArrayList<>();
        }
        return rsvpList;
    }

    private void initCounts() {
        Map<String, Long> counts = getRsvpList().stream().collect(
                Collectors.groupingBy(RSVPLite::getRsvpText, Collectors.summingLong(RSVPLite::getGuests)));

        rsvpAcceptCount = getCount(counts, RSVPCodeEnum.ACCEPT);
        rsvpWatchOnlineCount = getCount(counts, RSVPCodeEnum.WATCH_ONLINE);
        rsvpNeedTimeCount = getCount(counts, RSVPCodeEnum.NEED_MORE_TIME);
        rsvpDeclineCount = getCount(counts, RSVPCodeEnum.THANKS_BUT_DECLINE);
        rsvpTotalCount = rsvpAcceptCount + rsvpWatchOnlineCount + rsvpNeedTimeCount;

        Comparator<RSVPLite> rsvpComparator
                = Comparator.comparing(RSVPLite::getRsvpCode, (r1, r2) -> NumberUtils.compare(r1.getSortOrder(), r2.getSortOrder()));
        rsvpComparator = rsvpComparator.thenComparing(RSVPLite::getLastName);
        List<RSVPLite> sortedList = getRsvpList().stream().sorted(rsvpComparator).collect(Collectors.toList());
        setRsvpList(sortedList);
    }

    private Long getCount(Map<String, Long> counts, RSVPCodeEnum code) {
        Long count = counts.get(code.getText());
        return count == null ? 0L : count;
    }
}
