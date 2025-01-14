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

package ch.deletescape.lawnchair.location;

import android.content.Context;
import ch.deletescape.lawnchair.LawnchairPreferences;
import ch.deletescape.lawnchair.LawnchairUtilsKt;
import ch.deletescape.lawnchair.location.LocationManager.LocationProvider;
import ch.deletescape.lawnchair.smartspace.weather.forecast.ForecastProvider.ForecastException;
import com.android.launcher3.Utilities;
import java.util.concurrent.Executors;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WeatherCityLocationProvider extends LocationProvider implements
        LawnchairPreferences.OnPreferenceChangeListener {

    private Pair<Double, Double> location;

    public WeatherCityLocationProvider(
            @NotNull Context context) {
        super(context);
        Utilities.getLawnchairPrefs(context)
                .addOnPreferenceChangeListener("pref_weather_city", this);
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                LawnchairUtilsKt.getForecastProvider(getContext()).getGeolocation(
                        Utilities.getLawnchairPrefs(getContext()).getWeatherCity());
            } catch (ForecastException e) {
                e.printStackTrace();
            }
        });
    }

    @Nullable
    @Override
    public Pair<Double, Double> getLocation() {
        return location;
    }

    @Override
    public void onValueChanged(@NotNull String key, @NotNull LawnchairPreferences prefs,
            boolean force) {
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                LawnchairUtilsKt.getForecastProvider(getContext()).getGeolocation(
                        Utilities.getLawnchairPrefs(getContext()).getWeatherCity());
            } catch (ForecastException e) {
                e.printStackTrace();
            }
        });
    }
}
