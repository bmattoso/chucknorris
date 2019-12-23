package br.com.chucknorris.repository.core

import br.com.chucknorris.core.NetworkAvailability
import javax.inject.Inject

abstract class BaseRepository {

    @Inject
    lateinit var networkAvailability: NetworkAvailability
}
