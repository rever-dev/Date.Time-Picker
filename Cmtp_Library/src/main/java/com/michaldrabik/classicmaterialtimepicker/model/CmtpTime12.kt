package com.michaldrabik.classicmaterialtimepicker.model

import com.michaldrabik.classicmaterialtimepicker.CmtpTimeData
import com.michaldrabik.classicmaterialtimepicker.model.CmtpTimeType.HOUR_12

data class CmtpTime12(
  override val hour: Int,
  override val minute: Int,
  val pmAm: PmAm
) : CmtpTime {

  companion object {
    @JvmStatic
    val DEFAULT = CmtpTime12(6, 30, PmAm.下午)
  }

  init {
    check(hour in CmtpTimeData.HOURS_12) { "Invalid hour. Must be between 1 and 12" }
    check(minute in CmtpTimeData.MINUTES) { "Invalid minute. Must be between 0 and 59" }
  }

  override fun getType() = HOUR_12

  override fun toString() = String.format("%02d:%02d:%s", hour, minute, pmAm.name)

  fun toString(separator: String) = String.format("%02d$separator%02d$separator%s", hour, minute, pmAm.name)

  enum class PmAm { 下午, 上午 }
}