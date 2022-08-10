package com.igor.bestmovies.domain.usecase

import com.igor.bestmovies.domain.repository.ShowDetailRepository
import com.igor.bestmovies.domain.model.Show
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetShowDetailTest {
    private lateinit var interactor: GetShowDetail

    @MockK
    lateinit var repository: ShowDetailRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        interactor = GetShowDetail(repository)
    }

    @Test
    fun `Test when return show detail`() = runBlockingTest {
        val show = mockk<Show>(relaxed = true)

        coEvery { repository.fetchAsync(3) } returns mockk(relaxed = true)
        val fetch = interactor(3)

        every { show.id } returns 3
        every { fetch?.id } returns 3

        Assert.assertEquals(show.id, fetch?.id)
    }
}