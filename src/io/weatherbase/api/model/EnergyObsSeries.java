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

/*
 * Weatherbit.io - Swagger UI Weather API documentation
 * This is the documentation for the Weatherbit Weather API.  The base URL for the API is [http://api.weatherbit.io/v2.0/](http://api.weatherbit.io/v2.0/) or [https://api.weatherbit.io/v2.0/](http://api.weatherbit.io/v2.0/). Below is the Swagger UI documentation for the API. All API requests require the `key` parameter.        An Example for a 5 day forecast for London, UK would be `http://api.weatherbit.io/v2.0/forecast/3hourly?city=London`&`country=UK`. See our [Weather API description page](https://www.weatherbit.io/api) for additional documentation.
 *
 * OpenAPI spec version: 2.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.weatherbase.api.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Objects;
/**
 * EnergyObsSeries
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-07-23T18:38:21.490044+08:00[Asia/Shanghai]")
public class EnergyObsSeries {
  @SerializedName("date")
  private String date = null;

  @SerializedName("cdd")
  private BigDecimal cdd = null;

  @SerializedName("hdd")
  private BigDecimal hdd = null;

  @SerializedName("rh")
  private Integer rh = null;

  @SerializedName("dewpt")
  private BigDecimal dewpt = null;

  @SerializedName("wind_dir")
  private Integer windDir = null;

  @SerializedName("wind_speed")
  private BigDecimal windSpeed = null;

  @SerializedName("temp")
  private BigDecimal temp = null;

  @SerializedName("clouds")
  private Integer clouds = null;

  @SerializedName("t_ghi")
  private BigDecimal tGhi = null;

  @SerializedName("t_dhi")
  private BigDecimal tDhi = null;

  @SerializedName("t_dni")
  private BigDecimal tDni = null;

  @SerializedName("sun_hours")
  private BigDecimal sunHours = null;

  @SerializedName("precip")
  private BigDecimal precip = null;

  @SerializedName("snow")
  private BigDecimal snow = null;

  public EnergyObsSeries date(String date) {
    this.date = date;
    return this;
  }

   /**
   * Date
   * @return date
  **/
  @Schema(example = "2018-06-01", description = "Date")
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public EnergyObsSeries cdd(BigDecimal cdd) {
    this.cdd = cdd;
    return this;
  }

   /**
   * Cooling degree days
   * @return cdd
  **/
  @Schema(example = "10.0", description = "Cooling degree days")
  public BigDecimal getCdd() {
    return cdd;
  }

  public void setCdd(BigDecimal cdd) {
    this.cdd = cdd;
  }

  public EnergyObsSeries hdd(BigDecimal hdd) {
    this.hdd = hdd;
    return this;
  }

   /**
   * Heating degree days
   * @return hdd
  **/
  @Schema(example = "120.0", description = "Heating degree days")
  public BigDecimal getHdd() {
    return hdd;
  }

  public void setHdd(BigDecimal hdd) {
    this.hdd = hdd;
  }

  public EnergyObsSeries rh(Integer rh) {
    this.rh = rh;
    return this;
  }

   /**
   * Average Relative humidity (%)
   * @return rh
  **/
  @Schema(example = "75", description = "Average Relative humidity (%)")
  public Integer getRh() {
    return rh;
  }

  public void setRh(Integer rh) {
    this.rh = rh;
  }

  public EnergyObsSeries dewpt(BigDecimal dewpt) {
    this.dewpt = dewpt;
    return this;
  }

   /**
   * Average dew point temperature - Default (C)
   * @return dewpt
  **/
  @Schema(example = "12.0", description = "Average dew point temperature - Default (C)")
  public BigDecimal getDewpt() {
    return dewpt;
  }

  public void setDewpt(BigDecimal dewpt) {
    this.dewpt = dewpt;
  }

  public EnergyObsSeries windDir(Integer windDir) {
    this.windDir = windDir;
    return this;
  }

   /**
   * Average wind direction (Degrees)
   * @return windDir
  **/
  @Schema(example = "125", description = "Average wind direction (Degrees)")
  public Integer getWindDir() {
    return windDir;
  }

  public void setWindDir(Integer windDir) {
    this.windDir = windDir;
  }

  public EnergyObsSeries windSpeed(BigDecimal windSpeed) {
    this.windSpeed = windSpeed;
    return this;
  }

   /**
   * Average wind speed - Default (m/s)
   * @return windSpeed
  **/
  @Schema(example = "5.85", description = "Average wind speed - Default (m/s)")
  public BigDecimal getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(BigDecimal windSpeed) {
    this.windSpeed = windSpeed;
  }

  public EnergyObsSeries temp(BigDecimal temp) {
    this.temp = temp;
    return this;
  }

   /**
   * Average temperature - Default (C)
   * @return temp
  **/
  @Schema(example = "13.85", description = "Average temperature - Default (C)")
  public BigDecimal getTemp() {
    return temp;
  }

  public void setTemp(BigDecimal temp) {
    this.temp = temp;
  }

  public EnergyObsSeries clouds(Integer clouds) {
    this.clouds = clouds;
    return this;
  }

   /**
   * Average cloud cover (%)
   * @return clouds
  **/
  @Schema(example = "42", description = "Average cloud cover (%)")
  public Integer getClouds() {
    return clouds;
  }

  public void setClouds(Integer clouds) {
    this.clouds = clouds;
  }

  public EnergyObsSeries tGhi(BigDecimal tGhi) {
    this.tGhi = tGhi;
    return this;
  }

   /**
   * Total global horizontal solar irradiance (W/m^2)
   * @return tGhi
  **/
  @Schema(example = "3000.0", description = "Total global horizontal solar irradiance (W/m^2)")
  public BigDecimal getTGhi() {
    return tGhi;
  }

  public void setTGhi(BigDecimal tGhi) {
    this.tGhi = tGhi;
  }

  public EnergyObsSeries tDhi(BigDecimal tDhi) {
    this.tDhi = tDhi;
    return this;
  }

   /**
   * Total diffuse horizontal solar irradiance (W/m^2)
   * @return tDhi
  **/
  @Schema(example = "450.0", description = "Total diffuse horizontal solar irradiance (W/m^2)")
  public BigDecimal getTDhi() {
    return tDhi;
  }

  public void setTDhi(BigDecimal tDhi) {
    this.tDhi = tDhi;
  }

  public EnergyObsSeries tDni(BigDecimal tDni) {
    this.tDni = tDni;
    return this;
  }

   /**
   * Total direct normal solar irradiance (W/m^2)
   * @return tDni
  **/
  @Schema(example = "1200.0", description = "Total direct normal solar irradiance (W/m^2)")
  public BigDecimal getTDni() {
    return tDni;
  }

  public void setTDni(BigDecimal tDni) {
    this.tDni = tDni;
  }

  public EnergyObsSeries sunHours(BigDecimal sunHours) {
    this.sunHours = sunHours;
    return this;
  }

   /**
   * Average number of daily sun hours - # hours where Solar GHI &gt; 1000 W/m^2
   * @return sunHours
  **/
  @Schema(example = "4.5", description = "Average number of daily sun hours - # hours where Solar GHI > 1000 W/m^2")
  public BigDecimal getSunHours() {
    return sunHours;
  }

  public void setSunHours(BigDecimal sunHours) {
    this.sunHours = sunHours;
  }

  public EnergyObsSeries precip(BigDecimal precip) {
    this.precip = precip;
    return this;
  }

   /**
   * Total precipitation in period - Default (mm)
   * @return precip
  **/
  @Schema(example = "2.0", description = "Total precipitation in period - Default (mm)")
  public BigDecimal getPrecip() {
    return precip;
  }

  public void setPrecip(BigDecimal precip) {
    this.precip = precip;
  }

  public EnergyObsSeries snow(BigDecimal snow) {
    this.snow = snow;
    return this;
  }

   /**
   * Total snowfall in period - Default (mm)
   * @return snow
  **/
  @Schema(example = "10.0", description = "Total snowfall in period - Default (mm)")
  public BigDecimal getSnow() {
    return snow;
  }

  public void setSnow(BigDecimal snow) {
    this.snow = snow;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnergyObsSeries energyObsSeries = (EnergyObsSeries) o;
    return Objects.equals(this.date, energyObsSeries.date) &&
        Objects.equals(this.cdd, energyObsSeries.cdd) &&
        Objects.equals(this.hdd, energyObsSeries.hdd) &&
        Objects.equals(this.rh, energyObsSeries.rh) &&
        Objects.equals(this.dewpt, energyObsSeries.dewpt) &&
        Objects.equals(this.windDir, energyObsSeries.windDir) &&
        Objects.equals(this.windSpeed, energyObsSeries.windSpeed) &&
        Objects.equals(this.temp, energyObsSeries.temp) &&
        Objects.equals(this.clouds, energyObsSeries.clouds) &&
        Objects.equals(this.tGhi, energyObsSeries.tGhi) &&
        Objects.equals(this.tDhi, energyObsSeries.tDhi) &&
        Objects.equals(this.tDni, energyObsSeries.tDni) &&
        Objects.equals(this.sunHours, energyObsSeries.sunHours) &&
        Objects.equals(this.precip, energyObsSeries.precip) &&
        Objects.equals(this.snow, energyObsSeries.snow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, cdd, hdd, rh, dewpt, windDir, windSpeed, temp, clouds, tGhi, tDhi, tDni, sunHours, precip, snow);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnergyObsSeries {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    cdd: ").append(toIndentedString(cdd)).append("\n");
    sb.append("    hdd: ").append(toIndentedString(hdd)).append("\n");
    sb.append("    rh: ").append(toIndentedString(rh)).append("\n");
    sb.append("    dewpt: ").append(toIndentedString(dewpt)).append("\n");
    sb.append("    windDir: ").append(toIndentedString(windDir)).append("\n");
    sb.append("    windSpeed: ").append(toIndentedString(windSpeed)).append("\n");
    sb.append("    temp: ").append(toIndentedString(temp)).append("\n");
    sb.append("    clouds: ").append(toIndentedString(clouds)).append("\n");
    sb.append("    tGhi: ").append(toIndentedString(tGhi)).append("\n");
    sb.append("    tDhi: ").append(toIndentedString(tDhi)).append("\n");
    sb.append("    tDni: ").append(toIndentedString(tDni)).append("\n");
    sb.append("    sunHours: ").append(toIndentedString(sunHours)).append("\n");
    sb.append("    precip: ").append(toIndentedString(precip)).append("\n");
    sb.append("    snow: ").append(toIndentedString(snow)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
