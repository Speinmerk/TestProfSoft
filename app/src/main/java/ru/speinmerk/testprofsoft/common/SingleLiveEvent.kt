package ru.speinmerk.testprofsoft.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.annotation.MainThread

open class SingleLiveEvent<T> : MutableLiveData<T>() {
    private val mObservers = HashMap<Observer<in T>, Observer<T>>()
    private val mFirstObservers = ArrayList<Observer<in T>>()

    init {
        value = null
    }

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        mFirstObservers.add(observer)
        super.observe(owner, Observer<T> { t ->
            if (!mFirstObservers.remove(observer)) {
                observer.onChanged(t)
            }
        })
    }

    override fun observeForever(observer: Observer<in T>) {
        mFirstObservers.add(observer)
        val newObserver = Observer<T> { t ->
            if (!mFirstObservers.remove(observer)) {
                observer.onChanged(t)
            }
        }
        mObservers[observer] = newObserver
        super.observeForever(newObserver)
    }

    override fun removeObserver(observer: Observer<in T>) {
        val observerCustom = mObservers[observer]
        if (observerCustom == null) {
            super.removeObserver(observer)
        } else {
            mObservers.remove(observerCustom)
            super.removeObserver(observerCustom)
        }
    }

    @MainThread
    fun call() {
        value = null
    }

    fun postCall() {
        postValue(null)
    }
}