package br.com.chucknorris.coreui.scheduler

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun ui(): Scheduler

    fun io(): Scheduler
}
