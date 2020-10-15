require frequency-xml-list.inc

FREQUENCY_LIST = "unicable.xml"

do_install() {
    install -d ${D}${datadir}/enigma2/

    for i in ${FREQUENCY_LIST}; do
        install -m 0644 ${S}/xml/$i ${D}${datadir}/enigma2/$i
    done;
}
