package cloudExplorer;

public class S3 {
    /*
     * Cloud Explorer Copyright (C) December 20, 2013 By Phillip Tribble. This program
     * is free software; you can redistribute it and/or modify it under the terms of
     * the GNU General Public License as published by the Free Software Foundation;
     * either version 3 of the License, or (at your option) any later version. This
     * program is distributed in the hope that it will be useful, but WITHOUT ANY
     * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
     * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
     * You should have received a copy of the GNU General Public License along with
     * this program; if not, write to the Free Softw4are Foundation, Inc., 59 Temple
     * Place, Suite 330, Boston, MA 02111-1307 USA
     **/

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].contains("daemon")) {
                Daemon daemon = new Daemon();
                daemon.gui = false;
                daemon.start();
            }
        } else {
            try {
                NewJFrame gui = new NewJFrame();
                gui.main(args);
            } catch (Exception S3) {
            }
        }
    }
}
