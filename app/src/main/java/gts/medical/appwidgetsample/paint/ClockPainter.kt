package gts.medical.appwidgetsample.paint

import android.content.Context
import java.util.*

internal class ClockPainter{
    var hourDotColor = 0
    var minuteDotColor = 0
    var handsColor = 0
    var secondDotColor = 0
    var showDate = true
    var showSecond = true
    var datePrimaryColor = 0
    var dateSecondaryColor = 0
    var centerCirclePrimaryColor = 0
    var centerCircleSecondaryColor = 0

    /** The coordinates used to paint the clock hands.  */
    var xHandSec: Int = 0
    var yHandSec: Int = 0
    var xHandMin: Int = 0
    var yHandMin: Int = 0
    var xHandHour: Int = 0
    var yHandHour: Int = 0

    /** The size of the clock.  */
    private val WIDTH = 400
    private val HEIGHT = 400
    private var SCALE = 1f
    private var RADIUS = 0

    private var mBottom: Int = 0
    private var mTop: Int = 0
    private var mLeft: Int = 0
    private var mRight: Int = 0

    /** The length of the clock hands relative to the clock size.  */
    private val secondHandLength = WIDTH / 2 - 30
    private val minuteHandLength = WIDTH / 2 - 100
    private val hourHandLength = WIDTH / 2 - 130

    /** The distance of the dots from the origin (center of the clock).  */
    private val DISTANCE_DOT_FROM_ORIGIN = WIDTH / 2 - 30

    private val DIAMETER_BIG_DOT = 5
    private val DIAMETER_SMALL_DOT = 3
    private val DIAMETER_SECOND_DOT = 8
    private val DIAMETER_CENTER_BIG_DOT = 14
    private val DIAMETER_CENTER_SMALL_DOT = 6


    private lateinit var mCalendar: Calendar
    private lateinit var mContext: Context

}