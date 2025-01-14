/*
 *     Copyright (c) 2017-2019 the Lawnchair team
 *     Copyright (c)  2019 oldosfan (would)
 *     This file is part of Lawnchair Launcher.
 *
 *     Lawnchair Launcher is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Lawnchair Launcher is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Lawnchair Launcher.  If not, see <https://www.gnu.org/licenses/>.
 */

package ch.deletescape.lawnchair.feed

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ch.deletescape.lawnchair.*
import ch.deletescape.lawnchair.smartspace.LawnchairSmartspaceController.*
import ch.deletescape.lawnchair.smartspace.weather.forecast.ForecastProvider
import ch.deletescape.lawnchair.smartspace.weather.owm.OWMWeatherActivity
import com.android.launcher3.R
import java.io.IOException

class FeedDailyForecastProvider(c: Context) : FeedProvider(c), Listener {
    override fun onDataUpdated(weather: WeatherData?, card: CardData?) {
        if (weather != null) {
            weatherData = weather
            updateData()
        } else {
            weatherData = null
            updateData()
        }
    }

    private var forecast: ForecastProvider.DailyForecast? = null
    private var weatherData: WeatherData? = null

    init {
        c.applicationContext.lawnchairApp.smartspace.addListener(this)
    }

    private fun updateData() {
        runOnUiWorkerThread {
            if (weatherData != null) {
                try {
                    try {
                        forecast = context.forecastProvider
                                .getDailyForecast(weatherData!!.coordLat!!,
                                                   weatherData!!.coordLon!!)
                    } catch (e: ForecastProvider.ForecastException) {
                        e.printStackTrace()
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: NullPointerException) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onFeedShown() {
        // TODO
    }

    override fun onFeedHidden() {
        // TODO
    }

    override fun onCreate() {
        // TODO
    }

    override fun onDestroy() {
        // TODO
    }

    override fun getCards(): List<Card> {
        return if (forecast == null) emptyList() else listOf(
            Card(BitmapDrawable(context.resources, weatherData?.icon),
                 context.getString(R.string.forecast_s), object : Card.Companion.InflateHelper {
                    override fun inflate(parent: ViewGroup): View {
                        val recyclerView = LayoutInflater.from(parent.context).inflate(
                            R.layout.width_inflatable_recyclerview, parent, false) as androidx.recyclerview.widget.RecyclerView
                        if (forecast != null) {
                            recyclerView.layoutManager =
                                    androidx.recyclerview.widget.LinearLayoutManager(context, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
                                            false)
                            recyclerView.adapter = OWMWeatherActivity
                                    .DailyForecastAdapter(forecast!!, context,
                                                           (context.applicationContext as LawnchairApp).lawnchairPrefs.weatherUnit,
                                                           useWhiteText(backgroundColor, parent.context))
                        }
                        recyclerView.layoutParams = ViewGroup
                                .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                              ViewGroup.LayoutParams.MATCH_PARENT)
                        return recyclerView;
                    }

                }, Card.NO_HEADER, "nosort,top"))
    }
}