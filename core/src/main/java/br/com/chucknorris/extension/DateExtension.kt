package br.com.chucknorris.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

val brazilianLocale = Locale("pt", "BR")

private const val DATE_DEFAULT_UI_PATTERN = "MM/dd/yyyy"
private val defaultUiPattern = SimpleDateFormat(DATE_DEFAULT_UI_PATTERN, brazilianLocale)

private const val DATE_DEFAULT_PATTERN = "yyyy-MM-dd hh:mm:ss.SSSSSS"
private val defaultPattern = SimpleDateFormat(DATE_DEFAULT_PATTERN, brazilianLocale)

fun String.parseDate(): Date = defaultPattern.parse(this)

fun Date.parseString(): String = defaultUiPattern.format(this)