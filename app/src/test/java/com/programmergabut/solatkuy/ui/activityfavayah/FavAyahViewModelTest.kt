package com.programmergabut.solatkuy.ui.activityfavayah

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.programmergabut.solatkuy.CoroutinesTestRule
import com.programmergabut.solatkuy.DummyArgument
import com.programmergabut.solatkuy.data.QuranRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class FavAyahViewModelTest {

    private lateinit var viewModel: FavAyahViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule: CoroutinesTestRule = CoroutinesTestRule()

    @Mock
    private lateinit var quranRepository: QuranRepository

    private val msFavAyah = DummyArgument.msFavAyah

    @Before
    fun setUp() {
        viewModel = FavAyahViewModel(quranRepository)
    }

    @Test
    fun getFavAyah() = coroutinesTestRule.testDispatcher.runBlockingTest {
        verify(quranRepository).getListFavAyah()
    }

    @Test
    fun deleteFavAyah() = coroutinesTestRule.testDispatcher.runBlockingTest{
        viewModel.deleteFavAyah(msFavAyah)
        verify(quranRepository).deleteFavAyah(msFavAyah)
    }
}