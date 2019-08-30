package ch13;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年08月29
 */
public interface DiscardPolicy {
    void discard() throws DiscardException;
}
