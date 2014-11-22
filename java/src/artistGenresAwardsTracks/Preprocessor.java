/**
 * 
 */
package src.artistGenresAwardsTracks;

import src.artistGenresAwardsTracks.utils.IndexEngine;
import src.artistGenresAwardsTracks.utils.Parser;
import src.artistGenresAwardsTracks.utils.SearchEngine;
import src.artistGenresAwardsTracks.utils.Splitter;

/**
 * @author stefanlinner
 *
 */
public class Preprocessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Parse freebase data dump
		String freebaseDumpRDFPath = "/Volumes/SSD_SAMSUNG_840/freebase-rdf-2014-10-12-00-00.gz";
		String parsedDumpFilePath = "./data/artists_genres_awards_tracks/parsed_files/parsed_dump.txt";
		Parser.parseDump(freebaseDumpRDFPath, parsedDumpFilePath);
		
		//Split parsed dump to individual files
		String splitDir = "./data/artists_genres_awards_tracks/";
		Splitter.splitParsedDump(parsedDumpFilePath, splitDir);

		//Index individual files
		IndexEngine.indexNames();
		IndexEngine.indexAwards();
		IndexEngine.indexGenres();
		IndexEngine.indexTracks();
		
		//Extract genre names using created index NAMES, save to separate file and index
		SearchEngine.extractGenreNames();
		IndexEngine.indexGenreNames();
	}

}