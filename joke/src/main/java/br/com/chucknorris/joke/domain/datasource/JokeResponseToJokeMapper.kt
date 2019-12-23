package br.com.chucknorris.joke.domain.datasource

import br.com.chucknorris.extension.parseDate
import br.com.chucknorris.mapper.Mapper
import br.com.chucknorris.model.Joke
import br.com.chucknorris.service.joke.JokeResponse
import javax.inject.Inject

class JokeResponseToJokeMapper @Inject constructor() : Mapper<JokeResponse, Joke> {

    override fun map(from: JokeResponse): Joke {
        return Joke(
            id = from.id,
            date = from.date.parseDate(),
            image = from.image,
            description = from.description,
            url = from.url
        )
    }
}
