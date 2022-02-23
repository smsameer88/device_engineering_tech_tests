package com.domain.usecases

import com.domain.repo.INewsDataRepository
import javax.inject.Inject

class GetAllNewsUseCase @Inject constructor(private val iNewsDataRepository: INewsDataRepository) {

    suspend operator fun invoke() = iNewsDataRepository.getNews()
}
