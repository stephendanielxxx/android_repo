package com.ideaco.projectdia.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ideaco.projectdia.data.remote.AnimalRemoteDataSource
import com.ideaco.projectdia.data.repository.AnimalRepository
import com.ideaco.projectdia.data.service.AnimalService
import com.ideaco.projectdia.retrofit.AnimalRetrofit
import com.ideaco.projectdia.ui.model.AnimalResponse
import com.ideaco.projectdia.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class RandomAnimalsViewModel @Inject constructor(
    private val animalRepository: AnimalRepository
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val randomAnimalsLiveData = MutableLiveData<List<AnimalResponse>>()
    private val insertAnimalLiveData = MutableLiveData<ViewState<Boolean>>()

    fun getRandomAnimals(number: Int){
        compositeDisposable.add(
            animalRepository.getRandomAnimals(number)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<AnimalResponse>>() {
                    override fun onSuccess(t: List<AnimalResponse>) {
                        randomAnimalsLiveData.value = t
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    fun insertAnimal(animalResponse: AnimalResponse){
        compositeDisposable.add(
            animalRepository.insertAnimal(animalResponse)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Long>() {
                    override fun onSuccess(t: Long) {
                        insertAnimalLiveData.value = ViewState.success(true)
                    }

                    override fun onError(e: Throwable) {
                        insertAnimalLiveData.value = ViewState.error("Failed to insert data", null)
                    }

                })
        )
    }

    fun getRandomAnimalsLiveData(): MutableLiveData<List<AnimalResponse>> {
        return randomAnimalsLiveData
    }

    fun getInsertAnimalIveData(): MutableLiveData<ViewState<Boolean>>
        = insertAnimalLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}