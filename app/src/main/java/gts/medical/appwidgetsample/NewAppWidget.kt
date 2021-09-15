package gts.medical.appwidgetsample

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.graphics.*
import android.os.Handler
import android.widget.RemoteViews
import java.text.DateFormat
import java.util.*


class NewAppWidget : AppWidgetProvider() {


    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {

    val cal = Calendar.getInstance()
    val minute = cal[Calendar.MINUTE]
    val hour = cal[Calendar.HOUR]

    val startingAngle:Float = getCurrentHour(hour +1)
    Handler().postDelayed({
        updateAppWidget(context, appWidgetManager, appWidgetId)

    }, 1000)
    val views = RemoteViews(context.packageName, R.layout.new_app_widget)
    val dateString: String = DateFormat.getTimeInstance(DateFormat.FULL).format(Date())
/////////////////////
    val screenWidth = 420 //Give your device screen width here
    val horizontalCentreX = screenWidth / 2
    val circleCentrex = horizontalCentreX
    val circleCentreY = 150
    val radius = 130
    val arcRectStartingX = horizontalCentreX - radius
    val arcRectStartingY = 20
    val arcRectEndingX = horizontalCentreX + radius
    val arcRectEndingY = 280

    val b = Bitmap.createBitmap(screenWidth, 300, Bitmap.Config.ARGB_8888)

    val paintCircle = Paint()
    val circleView = Canvas(b)
    paintCircle.color = Color.parseColor("#353535")
    paintCircle.strokeWidth = 10F
    paintCircle.style = Paint.Style.FILL
    paintCircle.isAntiAlias = true

    circleView.drawCircle(
        circleCentrex.toFloat(),
        circleCentreY.toFloat(),
        radius.toFloat(),
        paintCircle
    )

    val paint = Paint()
    paint.isAntiAlias = true
    paint.color = Color.parseColor("#E84F34")
    paint.strokeWidth = 40f
    paint.style = Paint.Style.STROKE
    paint.strokeCap =Paint.Cap.BUTT
    val oval = RectF()
    oval.set(
        arcRectStartingX.toFloat(),
        arcRectStartingY.toFloat(),
        arcRectEndingX.toFloat(),
        arcRectEndingY.toFloat()
    )

    circleView.drawArc(
        oval,
        startingAngle,  (360 - (60 - minute) * 60 / 60 *Math.PI * 2).toFloat(),
        false,
        paint
    )

    views.setImageViewBitmap(R.id.imageView, b)
///////////

    views.setTextViewText(R.id.appwidget_update, dateString)
    val intentUpdate = Intent(context, NewAppWidget::class.java)
    intentUpdate.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
    val idArray = intArrayOf(appWidgetId)
    intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray)

    val pendingUpdate = PendingIntent.getBroadcast(
        context,
        appWidgetId, intentUpdate, PendingIntent.FLAG_UPDATE_CURRENT
    )


    views.setOnClickPendingIntent(R.id.imageView, pendingUpdate)

    appWidgetManager.updateAppWidget(appWidgetId, views)
}

fun getCurrentHour(hour:Int):Float{

    return if (hour == 1 || hour == 13){
        300F
    }else if (hour == 2 || hour == 14){
        330F
    }else if (hour == 3 || hour == 15){
        360F
    }else if (hour == 4 || hour == 16){
        30F
    }else if (hour == 5 || hour == 17){
        60F
    }else if (hour == 6 || hour == 18){
        90F
    }else if (hour == 7 || hour == 19){
        120F
    }else if (hour == 8 || hour == 20){
        150F
    }else if (hour == 9 || hour == 21){
        180F
    }else if (hour == 10 || hour == 22){
        210F
    }else if (hour == 11 || hour == 23){
        240F
    }else if (hour == 12 || hour == 24){
        270F
    }else{
        return 360F
    }

}