package datastructures.week5.day1;

public class PaymentUsingCC {
    /**
     * Write test enumeration for payment using credit card system
     */
    /**
     * - UI
     *     - cross browser
     *     - diff platforms (web/ app/ tablet/ IOT)
     *     -
     * - API
     *     - search
     *     - deffered login / pre-login
     *     - w/ JWT/ bearer, w/o tokens
     * - Compatibility -
     * - Usability- user expereince
     * - Security -
     * - Performance
     *     - load sequentially
     *     - spike test
     *     - concurrent
     * - Functional
     *     - business flows--> purely functional thingy
     *     - field level validations --> data enumeration
     * - Accessibility
     *     - magnifiers- dyselxic
     *     - text to speech
     *     - scanner through search
     */


    /**
     * UI :
     *      1.payment done through platforms : mobile/web apps
     *      2.cross browser for same app.
     *
     * -API :
     *      1.payment service based on the type of card provided, Visa or mastercard etc.
     *
     * - Performance :
     *      1. how long the payment is taking to reach third party like visa to get success or failure.
     *      2. concurrently if payment is made twice at a same time, which payment should be success.
     *
     * - Usability :
     *      1.
     *
     * - Security:
     *      1. payment link should not be shared or opened in multiple browsers.
     *
     *
     *
     * - Functional :
     *      Flow level validations :
     *      - where is payment is being done or invoked  : online or swipe card, tap to pay
     *      - success payment transition
     *      - failure payment transition
     *
     *      Field level validations :
     *          card number length
     *          special chars in allowed in card number.
     *          card details with ccv number validation
     *          card details exp date validation.
     *
     *
     */
}
