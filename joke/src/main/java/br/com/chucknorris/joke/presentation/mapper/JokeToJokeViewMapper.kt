package br.com.chucknorris.joke.presentation.mapper

import br.com.chucknorris.extension.parseString
import br.com.chucknorris.joke.presentation.JokeView
import br.com.chucknorris.mapper.Mapper
import br.com.chucknorris.model.Joke
import javax.inject.Inject

class JokeToJokeViewMapper @Inject constructor() : Mapper<Joke, JokeView> {

    override fun map(from: Joke): JokeView {
        return JokeView(
            from.date.parseString(),
            from.image,
            from.description,
            from.url
        )
    }
}
