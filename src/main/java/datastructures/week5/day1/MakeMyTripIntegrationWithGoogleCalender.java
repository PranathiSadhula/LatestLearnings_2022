package datastructures.week5.day1;

public class MakeMyTripIntegrationWithGoogleCalender {
    /**
     *  Test case enumeration for Make my trip to Google Calendar
     */

    /**
     * - UI
     *     - cross browser : how design looks on different browsers
     *     - diff platforms (web/ app/ tablet/ IOT)
     *     - Compatibility - on diff browsers with diff versions on diff platform versions
     * - API
     *     - api calls to open calendar, select date, choose diff months
     *     - same before login and after login
     *
     *
     * - Usability- user expereince
     *     - user exp to open calendar
     *     - select diff dates
     *     - select diff range of dates.
     *     - navigate btw months
     *
     * - Security -
     *     - this can be included in api while validating diff HTTP methods, and if those mthds can be manipulated kind of stuff
     * - Performance
     *     - load sequentially
     *     - spike test
     *     - concurrent
     *
     * - Functional
     *   - on successfull booking, creating an event and sync with google calendar.
     *   - timezones adjustment
     *   - event notification synchronized across all the devices logged in by google account.
     *   - on cancelling booking, event should be disappear from calander.
     *   - on rebooking, event should be re organized on calander
     *   - whenever 2 google accounts active on calander, bookign event should be created on the actual account only.
     *  - Negetive :
     *      - booking with non-google account(ex: yahoo), so the event/notification on google calendar shouldnot be created.
     *
     *     - flow level validations :
     *          - how calendar should be displayed and where should be the position.
     *          - how to open calender.
     *          - how to navigate btw months, years and dates.
     *          - where/which page or sceen landing on selecting a perticular date.
     *          - any tool tips available on hovering dates to show kind of least or highest price available booking slots.
     *          - select start date only and validate resulting page
     *          - select start and return dates to validate results page.
     *
     *     - field level validations
     *          - validate day, date, mnth and year selected
     *          -
     *
     *
     *
     *
     * - Accessibility
     *     - open calendar in diff ways : tab key, mouse over, clicks ets.
     *     - enter date into input to select date from calendar.
     *     -
     */
}
