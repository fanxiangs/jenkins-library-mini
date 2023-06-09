import org.yaml.snakeyaml.Yaml

def call(String versionYamlFilePath = 'VERSION') {
    def versionYamlContent = readFile(versionYamlFilePath)
    def versionMap = new Yaml().load(versionYamlContent)
    
    def major = versionMap.VERSION_MAJOR ?: 0
    def minor = versionMap.VERSION_MINOR ?: 0
    def release = versionMap.VERSION_RELEASE ?: 0
    def preRelease = versionMap.VERSION_PRERELEASE ?: 0
    
    def version = "${major}.${minor}.${release}-${preRelease}"
    return version
}
