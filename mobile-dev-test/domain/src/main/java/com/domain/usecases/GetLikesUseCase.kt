package com.domain.usecases

import com.domain.repo.INewsDataRepository
import javax.inject.Inject

class GetLikesUseCase @Inject constructor(private val iNewsDataRepository: INewsDataRepository) {

    suspend operator fun invoke(url: String) = iNewsDataRepository.getLikes(url)
}