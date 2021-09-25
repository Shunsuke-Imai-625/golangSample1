package presentator.dataaccess.entity;

public class GenreEntity {

    /** ジャンルID */
    private int genreId;

    /** ジャンル名 */
    private String genreName;

    /**
     * @return genreId
     */
    public int getGenreId() {
	return genreId;
    }

    /**
     * @param genreId
     *            セットする genreId
     */
    public void setGenreId(int genreId) {
	this.genreId = genreId;
    }

    /**
     * @return genreName
     */
    public String getGenreName() {
	return genreName;
    }

    /**
     * @param genreName
     *            セットする genreName
     */
    public void setGenreName(String genreName) {
	this.genreName = genreName;
    }

    /*
     * (非 Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "GenreEntity [genreId=" + genreId + ", genreName=" + genreName
		+ "]";
    }

}