package com.igor.bestmovies.domain.usecase

import com.igor.bestmovies.domain.repository.PopularShowRepository
import com.igor.bestmovies.domain.model.Genre
import com.igor.bestmovies.domain.model.Show
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetPopularShowTest {
    private lateinit var interactor : GetPopularShow

    @MockK
    lateinit var repository: PopularShowRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        interactor = GetPopularShow(repository)
    }

    @Test
    fun `When return empty list`() = runBlockingTest{
        val genre = mockk<List<Genre>>()
        val shows = mockk<List<Show>>(relaxed = true)

        coEvery { repository.fetchPopularShowsAsync() } returns mockk(relaxed = true)
        val response = interactor(genre)

        Assert.assertEquals(response.size, shows.size)
    }
}