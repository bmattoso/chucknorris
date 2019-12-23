package br.com.chucknorris.mapper

interface Mapper<in From, out To> {
    fun map(from: From): To
}
