package goodtests.login;

public abstract class Page <I extends Page<I>>{

    public I goToStartPage(){
        return (I) this;
    }
}
