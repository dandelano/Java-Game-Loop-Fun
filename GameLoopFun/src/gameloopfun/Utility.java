/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameloopfun;

import java.util.Random;

/**
 *
 * @author dannyjdelanojr
 */
public class Utility {
    // RANDOM NUMBERS


  Random internalRandom;
  public Utility()
  {
      
  }
  /**
   *
   */
  public final float random(float high) {
    // avoid an infinite loop when 0 or NaN are passed in
    if (high == 0 || high != high) {
      return 0;
    }

    if (internalRandom == null) {
      internalRandom = new Random();
    }

    // for some reason (rounding error?) Math.random() * 3
    // can sometimes return '3' (once in ~30 million tries)
    // so a check was added to avoid the inclusion of 'howbig'
    float value = 0;
    do {
      value = internalRandom.nextFloat() * high;
    } while (value == high);
    return value;
  }

  /**
   * ( begin auto-generated from randomGaussian.xml )
   *
   * Returns a float from a random series of numbers having a mean of 0
   * and standard deviation of 1. Each time the <b>randomGaussian()</b>
   * function is called, it returns a number fitting a Gaussian, or
   * normal, distribution. There is theoretically no minimum or maximum
   * value that <b>randomGaussian()</b> might return. Rather, there is
   * just a very low probability that values far from the mean will be
   * returned; and a higher probability that numbers near the mean will
   * be returned.
   *
   * ( end auto-generated )
   * @webref math:random
   * @see PApplet#random(float,float)
   * @see PApplet#noise(float, float, float)
   */
  public final float randomGaussian() {
    if (internalRandom == null) {
      internalRandom = new Random();
    }
    return (float) internalRandom.nextGaussian();
  }


  /**
   * ( begin auto-generated from random.xml )
   *
   * Generates random numbers. Each time the <b>random()</b> function is
   * called, it returns an unexpected value within the specified range. If
   * one parameter is passed to the function it will return a <b>float</b>
   * between zero and the value of the <b>high</b> parameter. The function
   * call <b>random(5)</b> returns values between 0 and 5 (starting at zero,
   * up to but not including 5). If two parameters are passed, it will return
   * a <b>float</b> with a value between the the parameters. The function
   * call <b>random(-5, 10.2)</b> returns values starting at -5 up to (but
   * not including) 10.2. To convert a floating-point random number to an
   * integer, use the <b>int()</b> function.
   *
   * ( end auto-generated )
   * @webref math:random
   * @param low lower limit
   * @param high upper limit
   * @see PApplet#randomSeed(long)
   * @see PApplet#noise(float, float, float)
   */
  public final float random(float low, float high) {
    if (low >= high) return low;
    float diff = high - low;
    return random(diff) + low;
  }


 /**
   * ( begin auto-generated from randomSeed.xml )
   *
   * Sets the seed value for <b>random()</b>. By default, <b>random()</b>
   * produces different results each time the program is run. Set the
   * <b>value</b> parameter to a constant to return the same pseudo-random
   * numbers each time the software is run.
   *
   * ( end auto-generated )
   * @webref math:random
   * @param seed seed value
   * @see PApplet#random(float,float)
   * @see PApplet#noise(float, float, float)
   * @see PApplet#noiseSeed(long)
   */
  public final void randomSeed(long seed) {
    if (internalRandom == null) {
      internalRandom = new Random();
    }
    internalRandom.setSeed(seed);
  }
}
