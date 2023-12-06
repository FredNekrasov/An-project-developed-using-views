package com.olympia.mfa.view_pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieDrawable
import com.olympia.databinding.MfaFragmentLottieTestBinding

class LottieTest : Fragment() {
    private lateinit var binding: MfaFragmentLottieTestBinding
    private val animations = arrayOf("Incorrect.json", "CorrectData.json")
    private var animation = "CorrectData.json"
    private var i = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MfaFragmentLottieTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            ReverseAnimation.setOnClickListener {
                AnimationView.setMinProgress(0.0f)
                AnimationView.setMaxProgress(1.0f)
                AnimationView.repeatCount = 1
                AnimationView.repeatMode = LottieDrawable.REVERSE
                AnimationView.playAnimation()
            }
            ChangeAnimation.setOnClickListener {
                if (i > animations.size - 1) i = 0
                animation = animations[i]
                i++
                AnimationView.setAnimation(animation)
                AnimationView.setMinProgress(0.0f)
                AnimationView.setMaxProgress(1.0f)
                AnimationView.repeatCount = LottieDrawable.INFINITE
                AnimationView.repeatMode = LottieDrawable.RESTART
                AnimationView.playAnimation()
            }
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = LottieTest()
    }
}